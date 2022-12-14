# DEVinHouse: Turma CLAMED

> Projeto 3 - DEVinDocs - DOCin

### Desenvolvimento de um software com o objetivo de realizar a gestão de documentos e colaboradores de uma empresa.
#### A aplicação foi desenvolvida em Java. O usuário deverá realizar o cadastro de novos colaboradores (funcionário, supervisor ou gerente), realizar login no sistema a partir de cada um deles e cadastrar documentos em uma base de dados. Cada colaborador tem um acesso diferente no sistema interno, devendo ele, após realizar o cadastro de um documento, tramitar para um colaborador de nível hierárquico superior, que deverá avaliar o documento e recusar ou aprovar o mesmo. Ao chegar no gerente, este deve avaliar se irá arquivar ou não o documento.

## Menu inicial:
##### Oferece ao usuário as seguintes opções:
1 - Cadastrar novo colaborador  
2 - Realizar login no sistema  
3 - Gerar relatório da lista de colaboradores  
4 - Gerar relatório do total de documentos arquivados  
0 - Sair

Para o bom funcionamento do sistema, o usuário deverá cadastrar pelo menos 1 colaborador de cada tipo no sistema, para que assim ele possa criar os documento e realizar os tramites entre eles.


**Exemplo de colaboradores cadastrados no sistema:**  

<img src="https://user-images.githubusercontent.com/108702072/198857607-fb847c25-134b-4f77-a592-f730d776957b.png" width="400px" />  

## Menu interno:  

**Diferentes opções no menu interno de acordo com o nível hierárquico do colaborador:**  

<img src="https://user-images.githubusercontent.com/108702072/198904616-f47f4eb5-8862-407e-8c70-aae6456dcd82.png" width="650px" /> 

## Lista de documentos:  

**Exemplo de documentos cadastrados no sistema, referenciados pelo ID do criador e tramitados para o responável de nível hierárquico superior:**  

<img src="https://user-images.githubusercontent.com/108702072/198904804-4dfcba40-f9cb-4a2c-8ff1-51fab7c1e017.png" width="580px" /> 

## Conhecimentos utilizados para o desenvolvimento da aplicação:
- **Introdução ao Java**:
Instalação, sintaxe básica, compilação, execução e documentação;
- **Estruturas de Controle e Fluxo**:
Condicionais, repetição, arrays e arraylist;
- **Conceitos de POO**:
 Classes, objetos, métodos, atributos, construtores, modificadores, encapsulamento, sobrecarga, herança e polimorfismo e tratamento de exceções;

> Desenvolvido por: Felipe de Oliveira Borba
