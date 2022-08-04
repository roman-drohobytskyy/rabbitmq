* Run RabbitMQ in Docker container:
```ssh
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```

* RabbitMQ web Console: http://localhost:15672/
