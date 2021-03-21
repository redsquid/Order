FROM archlinux:latest
RUN pacman -Sy && pacman -S --noconfirm jdk11-openjdk

COPY target/Order-1.0.jar /
COPY entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]

