# apde-delivery

Pour lancer un serveur RabbitMQ :

    docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

Pensez à modifier les identifiants vers une base de donnée mysql dans /src/main/ressources/application.properties

    spring.datasource.username=USERNAME
    spring.datasource.password=PASSWORD

Une fois l'API et le docker lancé, si un message arrive dans la queue, elle sera traité et aura pour but d'insérer une entrée dans la BDD.
