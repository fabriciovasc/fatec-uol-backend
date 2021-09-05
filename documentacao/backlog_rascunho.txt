PROJECT BACKLOG

Épicos

    Serviço que consiga classificar uma venda como: aprovada, reprovada, análise manual:

        Tasks:

            - Pesquisa sobre o assunto \ tecnologias
            - Desenvolvimento
            - Integração com a aplicação


    Serviço que consiga aprovar ou reprovar uma análise manual feature toggle que permita ligar e desligar o processo de análise cadastral:

        Tasks:

            - Pesquisa sobre o assunto \ tecnologias
            - Desenvolvimento
            - Integração com a aplicação


    Interface administrativa que permite aprovar ou reprovar uma análise manual:

        Tasks:

            - Pesquisa sobre o assunto \ tecnologias
            - Desenvolvimento


    Relatório contendo: identificação do cadastro, identificação da análise cadastral e o resultado da análise cadastral:

        Tasks:

            - Pesquisa sobre o assunto \ tecnolgias \ métodos utilizados
            - Desenvolvimento da solução



Sprint 1 - 30/08 - 19/09

 Gestão e Gov. de TI:

    - Desenvolvimento do Design Thinking


 Gestão de Projetos:

    - Termo de Abertura de Projeto
    - Gerenciamento de Escopo (EAP Escopo de Abertura de Projeto)
    - Gerenciamento de Cronograma (Tempo Total do Projeto + Tempo da Sprint 1)
    - Gerenciamento de Custo (Custo Total do Projeto +  Custo da Sprint 1)

 Tópicos Especiais:

    - Aplicação Springboot com acesso  a dados utilizando Spring Data JPA (já "entregue")

        Necessário adaptar para a situação da UOL (cadastro e-mail + cadastro de "perfis de usuários" que serão guardados os hashs gerados pelo canvas fingerprint para determinar de qual "perfil" é cada e-mail)

        Modificar o banco de dados - Deverá ter uma tabela de E-mail e uma de Perfil, sendo que a de e-mail irá conter os campos presentes no cadastro do e-mail BOL e a tabela de perfil será utilizada para mapears os perfis e e-mails, sendo que irá conter um campo para cada tipo de hash gerado pela lib "canvas fignerprint", um campo de indentificador único (UUID ou algum hash gerado por nós) e uma relação ManyToMany com o a tabela de e-mail.

    - Aplicação de serviços REST que deve seguir o padrão MVC possuindo:

        a.Rotas com diferentes métodos de acesso(GET,POST, DELETE e PUT);
        b.Tratamento de CORS;
        c.Formatação de JSON usando JsonView.

 Inteligência Artificial:

    - Não ficou definido ainda

 
 Gestão de Equipes(Processo):

    - Não há entregas (somente acompanhamento do processo geral)

=============================================================================================================================

 Sprint 2 - 

 Gestão e Gov. de TI:

    - Desenvolvimento do Design Thinking (Sprint 2)
    - Desenvolvimento BSC



 Gestão de Projetos:

    - Gerenciamento de Escopo (Backlog Sprint2)
    - Gerenciamento de Cronograma (Tempo da Sprint 2)
    - Gerenciamento de Custo (Custo da Sprint 2)
    - Gerenciamento de Qualidade

 Tópicos Especiais:

    - Aplicação do que foi desenvolvimento na sprint 1 com segurança. 
    - A aplicação deve possuir:
        a.Autenticação usando login e token JWT;
        b.Autorização por anotações (não anotar Controllers). Utilizar, no mínimo, dois níveis de autorização (Usuário e Administrador).

 Inteligência Artificial:

    - Não ficou definido ainda

 
 Gestão de Equipes(Processo):

    - Não há entregas (somente acompanhamento do processo geral)
