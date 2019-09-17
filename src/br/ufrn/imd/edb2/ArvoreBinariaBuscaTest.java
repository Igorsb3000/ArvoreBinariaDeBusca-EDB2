package br.ufrn.imd.edb2;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArvoreBinariaBuscaTest {

    @Test
    public void deveEncontrarElemento() {
        //Arrange
        ArvoreBinariaBusca b = new ArvoreBinariaBusca();
        b.insert(10);
        b.insert(12);
        b.insert(9);

        //Act
        Node n = b.search(9);

        //Assert
        assertNotNull(n);
    }
    @Test
    public void isEmptyDeveRetornarTrueSeNaoHouverElementos() {
        //arrange
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();

        //act
        boolean b = a.isEmpty();

        assertTrue(b);

        //arrange
        a.insert(1);

        //assert
        assertFalse(a.isEmpty());
    }
    @Test
    public void isnotemptydeveretornartruesenaohouverelementos() {
        //arrange
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();
        a.insert(1);

        //act
        boolean b = a.isEmpty();

        //assert
        assertFalse(b);
    }

    @Test
    public void deleteNoFolha(){
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);

        //act
        boolean resultado = tree.delete(2);

        //assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado);

    }

    @Test
    public void deleteNoCom1Filho() {
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(5);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(6);

        //act
        boolean resultado = tree.delete(9);

        //assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado);
    }

    @Test
    public void deleteNoCom2Filhos() {
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(5);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(6);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);

        //act
        boolean resultado = tree.delete(10);

        //assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado);
    }

    @Test
    public void deleteNoRaizCom1Filho() {
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(5);
        tree.insert(8);

        //act
        boolean resultado = tree.delete(5);

        //assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado);
    }

    @Test
    public void deleteNoRaizCom2Filhos() {
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);

        //act
        boolean resultado = tree.delete(5);

        //assert
        boolean resultado_esperado = true;
        assertEquals(resultado_esperado, resultado);
    }

    @Test
    public void deleteArvoreGrande() {
        //arranje
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();
        tree.insert(10);
        tree.insert(8);
        tree.insert(7);
        tree.insert(15);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(20);
        tree.insert(18);
        tree.insert(21);
        tree.insert(22);

        //act
        boolean resultado = tree.delete(15);


        //assert
        assertTrue(resultado);
    }


}
