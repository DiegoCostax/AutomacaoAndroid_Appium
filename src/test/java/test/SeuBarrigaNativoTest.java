package test;

import Appium.core.BaseTest;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;
import page.SeuBarriga.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import page.MenuPage;

import java.net.MalformedURLException;

public class SeuBarrigaNativoTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBloginPage page = new SBloginPage();
    private SBmenuPage menuSB = new SBmenuPage();
    private SBcontasPage contas = new SBcontasPage();
    private SBmovimentacaoPage mov = new SBmovimentacaoPage();
    private SBhomePage home = new SBhomePage();
    private SBresumoPage resumo = new SBresumoPage();

   @Before
    public void setup() throws MalformedURLException {
        //entrar no app
        menu.acessarSBNativo();
       page.setNome("diegoteste@gmail.com");
       page.setSenha("teste123");
       page.entrar();
    }
    @Test
    public void deveInserirContaComSucesso() throws MalformedURLException {
    //entrar em contas
    menuSB.acessarContas();
    //adicionar conta
    contas.setConta("Conta de Teste");
    //salvar
    contas.salvar();
    //Verificar mensagem
    Assertions.assertTrue(page.existeElementoPorTexto("Conta adicionada com sucesso"));
    }
    @Test
    public void deveExcluirConta() throws MalformedURLException{
        //entrar em contas
        menuSB.acessarContas();
        //clique longo
        contas.selecionarConta("Conta de Teste");
        //EXCLUIR
        contas.excluir();
        //verificar
        Assertions.assertTrue(page.existeElementoPorTexto("Conta excluída com sucesso"));
    }
    @Test
    public void deveValidarInclusaoMov() throws MalformedURLException {
       menuSB.acessarMov();
        //validar a desc
       mov.salvar();
       Assertions.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
       //validar inte
        mov.setDescricao("desc");
        mov.salvar();
        Assertions.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
        //validar valor
        mov.setInteressado("interessado");
        mov.salvar();
        Assertions.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
        //validar conta
        mov.setValor("123");
        mov.salvar();
        Assertions.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));

        //inserir com sucesso
        mov.setContaSpinner("abdd");
        mov.salvar();
        Assertions.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
    }
    @Test
    public void deveAtualizarSaldoAoExcluirMovimentação() throws MalformedURLException{
        //verificar saldo "Conta para saldo" = 534.00
        Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

        //ir para resumo
        menuSB.acessarResumo();

        //excluir Movimentacao 3
        resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

        //validar a mensagem "Movimentação removida com sucesso"
        Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));

        //voltar home
        menuSB.acessarHome();

        //atualizar saldos
        esperar(2000);
        home.scroll(0.3 , 0.8);

        //verificar saldo = -1000.00
        Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
    }

}