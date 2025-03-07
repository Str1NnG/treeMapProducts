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

http://localhost:8080/inserir-produtos

    {
  	"nanoSeconds": 4079800,
  	"totalProducts": 10000
    }

http://localhost:8080/consultar-produtos

    {
        "nanoSeconds": 22793000,
        "produtosAbaixoDe100": {
            "4480": {
              "id": -6.572126932511633e+18,
              "descricao": "Produto -6572126932511633073",
              "valor": 0.0110223740747136
            },
            "6686": {
              "id": -1.1134321988290276e+18,
              "descricao": "Produto -1113432198829027555",
              "valor": 0.0157396252129917
        },
      ],
        "produtosAcimaDe100": {
            "9294": {
              "id": 2.330546269776663e+18,
              "descricao": "Produto 2330546269776663036",
              "valor": 100.009228493701
            },
            "5604": {
              "id": 541334754425482100,
              "descricao": "Produto 541334754425482135",
              "valor": 100.029679565957
            },
        },
      ]
    }

http://localhost:8080/produtos

    {
        "nanoSeconds": 37300,
        "produtos": {
            "0": {
              "id": 2.0488705605215908e+18,
              "descricao": "Produto 2048870560521590883",
              "valor": 116.40549040913
            },
            "1": {
              "id": 1.0110462918277244e+18,
              "descricao": "Produto 1011046291827724436",
              "valor": 59.8280204648967
            },...


## Conclusão

Ao finalizar o sistema, foram realizados testes com o uso de árvores. Foi possivel obter uma performance melhor na inserção de 10.000 produtos, como mostrado a seguir:

    {
      "nanoSeconds": 4079800,
      "totalProducts": 10000
    }
    
O mais impactante foi em relação à buscar todos os produtos cadastrados no banco de dados:

    {
        "nanoSeconds": 37300,
    }
