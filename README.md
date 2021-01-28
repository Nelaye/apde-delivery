# apde-delivery

Pour lancer un serveur RabbitMQ :

    docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

Pensez à modifier les identifiants vers une base de donnée **mysql** dans */src/main/ressources/application.properties*

    spring.datasource.username=USERNAME
    spring.datasource.password=PASSWORD

Une fois l'API et le docker lancé, si un message arrive dans la queue "delivery" avec le format JSON (actuellement seul 3 attribut pour la démonstration):

    {buyer="BUYER", date="yyyy-MM-dd hh:mm:ss", address="ADDRESS"}
        
elle sera traité et aura pour but d'insérer une entrée dans la table deliveries: 

```SQL
    drop database if exists gla;

    create database if not exists gla;

    use gla;

    create table deliveries (
        id int not null auto_increment primary key,
        buyer int not null,
        date datetime not null,
        address varchar(255)
    );
```

