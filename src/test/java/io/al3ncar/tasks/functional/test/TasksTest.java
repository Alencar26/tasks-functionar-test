package io.al3ncar.tasks.functional.test;

import io.al3ncar.tasks.functional.core.BaseTest;
import io.al3ncar.tasks.functional.page.TasksPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.al3ncar.tasks.functional.core.DriverFactory.getDriver;

public class TasksTest extends BaseTest {

    final String URL = "http://localhost:8001/tasks/";
    private TasksPage page;

    @Before
    public void inicializar() {
        getDriver().get(URL);
        page = new TasksPage();
    }

    @Test
    public void deveSalvarTarefaComSucesso() {
        page.clicarNoBotaoAddTodo();
        page.adicionarTask("Task Selenium");
        page.adicionarDataFuturaEmDias(2);
        page.clicarNoBotaoSalvar();
        Assert.assertEquals("Success!", page.validarMensagemDeSucesso());
    }

    @Test
    public void naoDeveSalvarTarefaComDataPassada() {
        page.clicarNoBotaoAddTodo();
        page.adicionarTask("Task Selenium");
        page.adicionarDataPassada();
        page.clicarNoBotaoSalvar();
        Assert.assertEquals("Due date must not be in past", page.validarMensagemDeSucesso());
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao() {
        page.clicarNoBotaoAddTodo();
        page.adicionarDataFuturaEmDias(2);
        page.clicarNoBotaoSalvar();
        Assert.assertEquals("Fill the task description", page.validarMensagemDeSucesso());
    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        page.clicarNoBotaoAddTodo();
        page.adicionarTask("Task Selenium");
        page.clicarNoBotaoSalvar();
        Assert.assertEquals("Fill the due date", page.validarMensagemDeSucesso());
    }

    @Test
    public void deveRemoverUmaTarefaComSucesso() {
        //Adicionar tarefa cm sucesso:
        page.clicarNoBotaoAddTodo();
        page.adicionarTask("Essa tarefa vai ser deletada.");
        page.adicionarDataFuturaEmDias(2);
        page.clicarNoBotaoSalvar();
        Assert.assertEquals("Success!", page.validarMensagemDeSucesso());

        //Remover tarefa com sucesso:
        page.clicarNoBotaoRemover();
        Assert.assertEquals("Success!", page.validarMensagemDeSucesso());
    }
}
