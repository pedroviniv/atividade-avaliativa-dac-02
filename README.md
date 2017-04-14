# atividade-avaliativa-dac-02
___
Resolução da 2º atividade avaliativa da disciplina Desenvolvimento de Aplicações Corporativas.

Este repositório divíde-se em três projetos:
1. jpa-bank, sendo a resolução do "Cenário 1 - Sistema Bancário"
2. jpa-oficina, sendo a resolução do "Cenário 2 - Oficina"
3. jpa-editora, sendo a resolução do "Cenário 3 - Editora"

Tanto projeto 1 (um) como o projeto 3 (três) listados acima contém uma classe nomeada "App" no pacote main.
Esta classe realiza a manipulação das entidades JPA de acordo com o que é peço nos requisitos de cada cenário
da atividade. (Qualquer informação referente a atividade é descrito [nest docuemento](Atividade.pdf).)

Porém, o projeto 2 (dois) foi desenvolvido usando Enterprise Java Beans (EJB) e Java Transaction API (JTA),
Desta forma, o projeto 2 contém dois módulos. O módulo `shared` e o módulo `core`.

No módulo `shared` estão todas as classes e interfaces que é compartilhada com o módulo `core` e com possíveis outros módulos caso fosse necessário. Desta maneira, o módulo `shared` contém:
- Classes de domínio já mapeadas utilizando Java Persistence API (JPA)
- Interfaces de serviços que são implementadas no módulo core.


Já o módulo `core` utiliza o módulo `shared` como dependência, implementando todas as interfaces de serviços 
definidas no ultimo. Desta forma, o módulo `core` também é composta pela camada de Data Access Object (DAO) que são usadas pelos serviços. As implementações das interfaces de serviços, estão no pacote `br.edu.ifpb.dac.jpa.oficina.core.services`
e as implementações da camada DAO estão no pacote `br.edu.ifpb.dac.jpa.oficina.core.dao`.

Para implantar o módulo core, disponibilizando remotamente as regras de negócio do Cenário 3 da atividade, basta abrir o seu terminal e no diretório do projeto inserir o comando `mvn clean install`. O arquivo War será gerado, podendo ser implantado no Payara ou no Glassfish.