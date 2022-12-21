package io.al3ncar.tasks.functional.page;

import io.al3ncar.tasks.functional.core.BasePage;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class TasksPage extends BasePage {

	public void clicarNoBotaoAddTodo() {
		dsl.clicarBotaoPorId("addTodo");
	}

	public void adicionarTask(String texto) {
		dsl.escreverById("task", texto);
	}

	public void adicionarDataFuturaEmDias(int dias) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(DAY_OF_MONTH, dias);
		String dataFutura = new SimpleDateFormat("dd/MM/yyyy").format(gc.getTime());
		dsl.escreverById("dueDate", dataFutura);
	}

	public void adicionarDataPassada() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(DAY_OF_MONTH, -2);
		String dataFutura = new SimpleDateFormat("dd/MM/yyyy").format(gc.getTime());
		dsl.escreverById("dueDate", dataFutura);
	}

	public void clicarNoBotaoSalvar() {
		dsl.clicarBotaoPorId("saveButton");
	}

	public String validarMensagemDeSucesso() {
		return dsl.validarTexto("message");
	}

	public String validarBuildDeProducao() {
		return dsl.validarTexto("version");
	}

	public void clicarNoBotaoRemover() {
		dsl.clicarElementoXPath("//a[@class='btn btn-outline-danger btn-sm'] ");
	}
}
