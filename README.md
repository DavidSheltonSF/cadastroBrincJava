# cadastroBrincJava

Código desenvolvido usando **arquitetura em camadas**.

Atividade Mapa da disciplina de Programação de Sistemas II

Em um shopping há um espaço de diversão para que os clientes podem deixar suas crianças enquanto fazem compras. Desenvolva um sistema com uma interface Java Swing para realizar o cadastro, o controle e a cobrança do tempo utilizado pelas crianças no brinquedo.

O sistema deve ser criado utilizando Java Swing, e o processo deve conter três telas que serão executadas sequencialmente:

A Tela 1 deve armazenar dados do responsável.
A Tela 2 deve armazenar dados da criança.
A Tela 3 deve armazenar dados do tempo no brinquedo, bem como mostrar o resumo da utilização e o valor a ser cobrado.

Esse programa deve ser desenvolvido utilizando os conceitos de Orientação a Objetos, portanto deve ter as classes:

- Responsável com nome, CPF, telefone, e-mail, endereço e idade.
- Criança com Responsável, nome, idade e sexo.
- Estadia com Responsável, Criança e tempo utilizado.

O programa deve seguir as seguintes regras:

Para ser responsável, a pessoa tem que ser maior de idade, portanto, no cadastro de idade, é necessário verificar se a idade é igual ou superior a 18.
Para a criança poder brincar ela tem que ter menos de 10 anos, portanto, no cadastro, é necessário verificar se a idade da criança é igual ou menor que 10.
Para estadia, deve ser cobrado o valor do minuto (R$1,50); para tempo superior a 20 minutos deve conceder 5% de desconto; para mais de 40 minutos conceder 10%; e mais de 60 minutos conceder 15% de desconto.

Observações:

- Essas regras devem ser implementadas nos métodos das classes do domínio, separando assim a tela da regra de negócio.
- Os objetos cadastrados devem ser passados por parâmetros para próxima tela.

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/babbb428-e6bb-4076-88ec-44797fc669c7)

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/96f74cc4-de38-4001-b543-2c47a2eb6183)

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/f7487ea7-38f1-4ec4-9ce3-cdb952e55771)

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/3f054087-b1ee-4134-af5e-4ae8acee9c1a)

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/45fa44e4-2d83-4968-88f0-8f6fbbd593f5)

![image](https://github.com/DavidSheltonSF/cadastroBrincJava/assets/79729565/b5525c2a-ea7a-4160-bbdb-0c9e64751666)

