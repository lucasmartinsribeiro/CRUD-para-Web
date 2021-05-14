package Controller;

import model.Jogos;
import model.dao.JogoDaoJpa;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "JogoSrv", value = "/JogoSrv")
public class JogoSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html:charset=UTF-8");
        try {
            String acao = request.getParameter("acao");

            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String diretor = request.getParameter("diretor");
            String anoLancamento = request.getParameter("anoLancamento");
            String status = request.getParameter("status");

            InterfaceDao dao = DaoFactory.novoJogoDao();
            Jogos j = null;
            RequestDispatcher rd = null;

            switch (acao) {
                case "inclusao":
                    j = new Jogos(nome, diretor, anoLancamento, status);
                    try {
                        dao.incluir(j);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);

                    break;

                case "pre-edicao":
                    j = (Jogos) dao.pesquisarporId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("Formulario.jsp?acao=edicao"
                            + "&id=" + j.getId()
                            + "&nome=" + j.getNome()
                            + "&diretor=" + j.getDiretor()
                            + "&anoLancamento=" + j.getAnoLancamento()
                            + "&status=" + j.getStatus());
                    rd.forward(request, response);
                    break;

                case "edicao":
                    j = new Jogos(nome, diretor, anoLancamento, status);
                    j.setId(Integer.parseInt(id));
                    try {
                        dao.editar(j);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "exclusao":
                    try {
                        j = new Jogos();
                        j.setId(Integer.parseInt(id));
                        dao.excluir(j);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pesquisarJogo":
                    String nomePesquisa = request.getParameter("pesquisa");
                    List <Jogos> pesquisarNome = null;
                    pesquisarNome = dao.pesquisarporNome(nomePesquisa);
                    String listaHTML = "";
                    for (Jogos jogos : pesquisarNome) {
                        listaHTML = listaHTML
                                + "<tr>"
                                + "<td> " + jogos.getNome() + "</td>"
                                + "<td> " + "</td>"
                                + "<td> " + jogos.getDiretor() + "</td>"
                                + "<td> " + "</td>"
                                + "<td> " + jogos.getAnoLancamento() + "</td>"
                                + "<td> " + "</td>"
                                + "<td> " + jogos.getStatus() + "</td>"
                                + "<td> " + "</td>"

                                + "<td><form action=JogoSrv?acao=pre-edicao method='POST'>"
                                + "<input type='hidden' name='id' value="
                                + jogos.getId() + "><input type='submit' value=Editar>"
                                + "</form></td>"
                                + "<td> " + "</td>"
                                + "<td><form action=JogoSrv?acao=exclusao method='POST'>"
                                + "<input type='hidden' name='id' value="
                                + jogos.getId() + "><input type='submit' value=Excluir>"
                                + "</form></td>"
                                + "</tr>";
                    }
                    request.getRequestDispatcher("Pesquisa.jsp?pesquisaNome="+ listaHTML).forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(JogoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String listagem() {
        InterfaceDao dao = new JogoDaoJpa();
        List<Jogos> lista = null;

        try {
            lista = dao.listar();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        String listaHTML = "";
        for (Jogos jogos : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td> " + jogos.getNome() + "</td>"
                    + "<td> " + "</td>"
                    + "<td> " + jogos.getDiretor() + "</td>"
                    + "<td> " + "</td>"
                    + "<td> " + jogos.getAnoLancamento() + "</td>"
                    + "<td> " + "</td>"
                    + "<td> " + jogos.getStatus() + "</td>"
                    + "<td> " + "</td>"

                    + "<td><form action=JogoSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + jogos.getId() + "><input type='submit' value=Editar>"
                    + "</form></td>"
                    + "<td> " + "</td>"
                    + "<td><form action=JogoSrv?acao=exclusao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + jogos.getId() + "><input type='submit' value=Excluir>"
                    + "</form></td>"
                    + "</tr>";
        }
        return listaHTML;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
