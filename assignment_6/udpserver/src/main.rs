use jaded::Parser;
use jaded_derive::FromJava;
use tokio::io::{self, Interest};
use tokio::net::UdpSocket;

#[derive(FromJava)]
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
                    if let Ok(mut parsed) = Parser::new(&data[..n]) {
                        // if let Ok(read) = parsed.read() {
                        //     println!("{:#?}", read);
                        // }

                        match parsed.read_as::<Person>() {
                            Ok(p) => {
                                println!(
                                    "Received {} bytes: {}, {}, {}",
                                    n, p.name, p.place, p.year
                                );
                            }
                            Err(_) => {
                                println!("Couldn't parse to Person");
                            }
                        }
                    }
                }
                Err(ref e) if e.kind() == io::ErrorKind::WouldBlock => {}
                Err(e) => {
                    return Err(e);
                }
            }
        }
    }
}
