# Agendamento API - Sistema de Agendamento de Serviços

## O que a API faz

- Autenticação com JWT: Cadastro de usuários e login com geração de token de acesso.
- Senhas Seguras: Senhas salvas de forma criptografada com BCrypt.
- Controle de Acesso:
  - ROLE_ADMIN: Pode cadastrar novos serviços.
  - ROLE_USER / ROLE_ADMIN: Podem realizar agendamentos.
- Regra de Horário: Bloqueia automaticamente mais de um agendamento no mesmo horário para o mesmo prestador (existsByPrestadorAndDataHora).
- Swagger UI: Documentação visual para testar os endpoints direto do navegador enviando o token JWT.

---

## Tecnologias

- Java 
- Spring Boot
- Spring Security + JWT 
- Spring Data JPA + Banco H2 
- Springdoc OpenAPI (Swagger UI)
- Lombok e Maven

---

## Como Rodar na Sua Máquina


1. Clone o repositório:
   git clone https://github.com/gabrieltsusato/agendamento-api.git
   cd agendamento-api

2. Instale as dependências e compile:
   mvn clean install

---

## Testando os Endpoints pelo Swagger

Abra no navegador:  
http://localhost:8080/swagger-ui.html

### Fluxo para Testar:

1. Cadastre um Admin (POST /api/auth/register):
   {
     "nome": "Carlos Admin",
     "email": "admin@email.com",
     "senha": "123",
     "role": "ROLE_ADMIN"
   }

2. Faça Login (POST /api/auth/login):
   - Envie o e-mail e senha cadastrados para receber o token.

3. Autentique no Swagger:
   - Clique no botão Authorize (no topo da tela) e cole o token JWT gerado.

4. Cadastre um Serviço (POST /api/servicos):
   - Crie um serviço (ex: "Corte de Cabelo", preco: 50.00).

5. Cadastre um Cliente (POST /api/auth/register):
   - Cadastre outro usuário com a role "ROLE_USER".

6. Faça um Agendamento (POST /api/agendamentos):
   - Envie os IDs do cliente, prestador, serviço e a data/hora desejada.

7. Teste o Bloqueio de Horário:
   - Tente enviar exatamente o mesmo agendamento no mesmo horário para o mesmo prestador e veja a API bloquear o registro.

---

## Banco de Dados (Console H2)

- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:agendamentodb
- Usuário: sa
- Senha: (deixar em branco)
