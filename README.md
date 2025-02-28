# Árvore Rubro Negra 

O projeto tem como objetivo exemplificar o uso de Árvores Rubro-Negras em uma aplicação que cadastra 10.000 (dez mil) produtos e apresenta os mesmos. Dessa forma, a aplicação foca na implementação e demonstração do desempenho das Árvores Rubro-Negras nesse contexto.

## Tecnologias utilizadas

- SpringBooot

## Configurações em localhost
    
  - Instalar o JDK21 do Java; 
  - Instalar o Maven em sua máquina;


## Dependências implantadas

- Spring Web
- Lombok
- Spring Boot DevTools

## Inicialização

### No Windows

  - Execute o comando para limpar e reconstruir o projeto spring:
    -  ./mvnw clean package
        
  - Execute o comando para rodar o projeto:
    - ./mvnw spring-boot:run

## Endpoints

O protejo tem dois endpoints, onde um é responsável pela inserção dos produtos, e outro que é responsável pela listagem.
O endpoint de listagem mostra apenas 

http://localhost:8080/inserir-produtos

http://localhost:8080/consultar-produtos


## Conclusão

Ao finalizar o sistema, foram realizados testes com o uso de árvores. Veja o resultado de um desses testes ao inserir 10.000 produtos:

	  {
      "nanoSeconds": 33285476200,
      "totalProducts": 10000
    }
