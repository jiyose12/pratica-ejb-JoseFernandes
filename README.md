# pratica-ejb-JoseFernandes
projeto da disciplina sistemas distribuidos IFPB
# Passos
Baixe o servidor de aplicações Wildfly: https://www.wildfly.org/downloads<br/>
Descompacte o arquivobr/>
Baixe o projeto demonstrado em sala, ou dê um fork na sua conta do github, já que parte da resposta será o link das alterações: https://github.com/gugawag/pratica-ejb<br/>
Abra o projeto no IntelliJbr/>
Clique em Edit Configurations… como na imagem abaixo para inserir o servidor Wildfly no projeto:<br/>

1. Clique no + no canto superior esquerdo e escolha JBoss Server ( Local)
2. Em Application Server, clique no botão Configure
3. Clique na pasta em JBoss Home e escolha a pasta do Wildfly que você baixou (pasta já descompactada)
4. Clique em ok.
5. Clique na aba Deployment e no + para escolher o artefato que será implantado no servidor: escolha o pratica-ejb:war (ou outro nome que esteja aparecendo do projeto)
6. Clique em ok até fechar tudo


Uma vez que o servidor esteja configurado, clique no botão de execução ao lado do servidor (seta verde, ou mesmo o bug verde para debug) e veja a aplicação executando (insira alguns usuários para ver o resultado)<br/>
Após executar, a aplicação deveria estar assim:<br/>
Altere o código da seguinte forma:<br/>
 Obs.: Ao final, você terá uma comunicação com fluxo da seguinte forma: Servlet -> Service -> DAO -> BancoDados<br/>
1. Crie uma classe de modelo, no mesmo pacote da classe Usuario, chamada Mensagem, que terá como atributos: id e texto (num design normal, teria ligação com Usuário. Porém, vamos simplificar aqui)
2. Marque a classe como @Entity e coloque o atributo id como sendo a chave primária com o @Id (ambas anotações da JPA, estando em import javax.persistence.)
3. Desenvolva a classe MensagemDAO, que será um EJB Stateless e terá um EntityManager injetado, similar à classe UsuarioDAO
4. A classe MensagemDAO deve ter os métodos inserir, listar e pesquisarPorId, que deve receber o id de uma mensagem como parâmetro e pesquisar apenas a mensagem do id especificado
5. Desenvolva a classe MensagemService, que será um EJB Stateless, e terá como nome para lookup sendo "mensagemService": @Stateless(name = "usuarioService")
6. Olhe a classe UsuarioService e veja as anotações necessárias
7. Crie o atributo MensagemDAO, que será injetado via a anotação @EJB, para que você o use para realizar as operações no banco de dados
8. Desenvolva um servlet, similar ao UsuarioServlet, chamado MensagemServlet, que será o cliente do serviço de mensagens
9. Altere o index.html para ter as operações sobre mensagens, chamando apropriadamente o MensagemServlet

