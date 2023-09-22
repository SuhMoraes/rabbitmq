
# Microserviço de Fila com RabbitMQ

Este é um exemplo de microserviço que demonstra como criar um serviço de fila usando RabbitMQ, Java 17, Spring Boot, Spring Web, Lombok e Spring RabbitMQ. A API é documentada usando Swagger.

## Pré-requisitos
- Java 17
- Spring Boot
- Spring Web
- Spring For RabbitMQ
- Lombok
- Swagger
- Docker 
- Docker Compose

## Iniciando o RabbitMQ via Docker Compose

Para iniciar um container do RabbitMQ, você pode usar o Docker Compose. 
Comando para criar o arquivo de Docker Compose
O arquivo `docker-compose.yml` já está configurado para você:

```bash
touch docker-compose.yml
```

- No `docker-compose.yml`, adicione:

```
version: "3.2"
services:
 rabbitmq:
  image: rabbitmq:3-management-alpine
  container_name: 'rabbitmq'
 ports:
  - 5672:5672
  - 15672:15672
 volumes:
  - ~/.docker-conf/rabbitmq/data/:/var/lib/rabbitmq/
  - ~/.docker-conf/rabbitmq/log/:/var/log/rabbitmq
 networks:
  - rabbitmq_curso

networks:
 rabbitmq_curso:
  driver: bridge

```

Obs:A formatação do arquivo `.yml` pode ser sensível à identação, portanto, é importante garantir que a identação esteja de acordo com o que o arquivo requer.

- Após a construção do `docker-compose`, rode o comando:

``` docker-compose up -d```

Isso iniciará o RabbitMQ em segundo plano.

## Executando o Microserviço

Para executar o microserviço, você pode usar o Maven:

```bash
./mvnw spring-boot:run
```

O serviço estará disponível em http://localhost:8080.

## Documentação da API

A documentação da API é gerada automaticamente pelo Swagger e pode ser acessada em http://localhost:8080/swagger-ui.html.

## Configuração

A configuração do RabbitMQ está no arquivo `application.yml`. Certifique-se de ajustar as configurações, se necessário.

## Exemplo de Uso

Aqui está um exemplo simples de como enviar uma mensagem para a fila usando curl:

```bash
curl -X POST "http://localhost:8080/api/send-message" -H "Content-Type: application/json" -d '{"message": "Minha mensagem para a fila"}'
```

## Contribuição

Sinta-se à vontade para contribuir para este projeto. Você pode relatar problemas, enviar solicitações de pull e fazer melhorias.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.

## Agradecimentos

- Spring Framework: https://spring.io/
- RabbitMQ: https://www.rabbitmq.com/
- Swagger: https://swagger.io/
```

Lembre-se de que este é apenas um exemplo e você deve personalizar o README de acordo com as especificidades do seu projeto. Certifique-se de adicionar detalhes específicos sobre a configuração, a estrutura do projeto, os endpoints da API, os modelos de mensagens RabbitMQ e outras informações importantes para os usuários e colaboradores do seu projeto.