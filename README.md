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
    -  mvnw clean package
        
  - Execute o comando para rodar o projeto:
    - mvnw spring-boot:run

## Endpoints

O protejo tem três endpoints, onde um é responsável pela inserção dos produtos, outro que é responsável pela listagem de prodututos abaixo e acima de 100 (limitados a 5), e por fim o ultimo endpoint é responsável por listar tudo o que foi armazenado.
O endpoint de listagem mostra apenas 

http://localhost:8080/inserir-produtos

    {
  	"nanoSeconds": 6716700,
  	"totalProducts": 10000
    }

http://localhost:8080/consultar-produtos

    {
        "nanoSeconds": 1150000,
        "produtosAbaixoDe100": [
        {
            "id": 0,
            "descricao": "Produto 1",
            "valor": 79.6236125757868
        },
        {
            "id": 3,
            "descricao": "Produto 4",
            "valor": 81.4091895847652
        },
        {
            "id": 5,
            "descricao": "Produto 6",
            "valor": 24.213944102614
        },
        {
            "id": 7,
            "descricao": "Produto 8",
            "valor": 5.93934726165494
          },
        {
            "id": 8,
            "descricao": "Produto 9",
            "valor": 68.9353069377223
        }
      ],
        "produtosAcimaDe100": [
        {
            "id": 1,
            "descricao": "Produto 2",
            "valor": 128.822041771129
         },
        {
            "id": 2,
            "descricao": "Produto 3",
            "valor": 172.096545062721
        },
        {
            "id": 4,
            "descricao": "Produto 5",
            "valor": 134.864926438025
        },
        {
            "id": 6,
            "descricao": "Produto 7",
            "valor": 150.316579361352
        },
        {
            "id": 10,
            "descricao": "Produto 11",
            "valor": 100.324144634568
        }
      ]
    }

http://localhost:8080/produtos

    {
        "nanoSeconds": 403800,
        "produtos": [
        {
            "id": 0,
            "descricao": "Produto 1",
            "valor": 79.6236125757868
        }...


## Conclusão

Ao finalizar o sistema, foram realizados testes com o uso de árvores. Veja o resultado de um desses testes ao inserir 10.000 produtos:

    {
      "nanoSeconds": 6779500,
      "totalProducts": 10000
    }
