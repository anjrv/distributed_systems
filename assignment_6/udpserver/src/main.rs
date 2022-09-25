use jaded::Parser;
use jaded_derive::FromJava;
use tokio::io::{self, Interest};
use tokio::net::UdpSocket;

#[derive(Debug, FromJava)]
struct Person {
    name: String,
    place: String,
    year: i32,
}

#[tokio::main]
async fn main() -> io::Result<()> {
    let socket = UdpSocket::bind("127.0.0.1:3002").await?;

    loop {
        let ready = socket.ready(Interest::READABLE).await?;

        if ready.is_readable() {
            let mut data = [0; 1024];
            match socket.try_recv(&mut data[..]) {
                Ok(n) => {
                    let parser = Parser::new(&data[..n]);
                    let p: Person = parser.unwrap().read_as().unwrap();
                    println!("Read Object: {:#?}", p);
                }
                Err(ref e) if e.kind() == io::ErrorKind::WouldBlock => {}
                Err(e) => {
                    return Err(e);
                }
            }
        }
    }
}
