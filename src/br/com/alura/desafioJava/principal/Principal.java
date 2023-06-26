package br.com.alura.desafioJava.principal;

import br.com.alura.desafioJava.modelos.CartaoDeCredito;
import br.com.alura.desafioJava.modelos.Produto;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        boolean queroSair = false;

        System.out.println("""
                \n
                *********************************************************
                            Seja bem-vindo ao E-commerce!
                *********************************************************
                \n
                """);

        System.out.println("Dígite o limite do seu cartão ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);

        while (!queroSair) {
            System.out.println("""
                        \n
                    ---------------------------------------------------------
                    O que gostaria de fazer?
                                   
                    ~~Digite o número correspondente:
                    0 - Sair
                    1 - Comprar
                    ---------------------------------------------------------
                    \n
                    """);

            int operacao = leitura.nextInt();

            if (operacao == 0) {
                System.out.println("""
                        \n
                        ---------------------------------------------------------
                                    Saindo...
                                    Obrigado por comprar conosco!
                        ---------------------------------------------------------
                        \n
                        """);

                queroSair = true;
            } else if (operacao == 1) {
                System.out.println("Oque gostaria de comprar?");
                String descricao = leitura.next();

                System.out.println("Qual o valor do produto?");
                double valor = leitura.nextDouble();

                Produto produto = new Produto(descricao, valor);
                boolean compraRealizada = cartaoDeCredito.lancaProduto(produto);

                if (compraRealizada) {
                    System.out.println("""
                        \n
                        -- Compra Realizada com sucesso!
                        Limite de crédito restante:   
                        """ + cartaoDeCredito.getSaldo() + "\n");

                    System.out.println(cartaoDeCredito.getProdutos().toString());
                } else {
                    System.out.println("""
                            \n
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                    Saldo insuficiente!
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
                            \n       
                            """);
                    System.out.println("""
                        Limite de crédito restante:   
                        """ + cartaoDeCredito.getSaldo() + "\n");
                }

            } else {
                System.out.println("""
                        \n
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                Operação inválida
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
                        \n       
                        """);
            }
        }

        System.out.println("--------------------------------------------");
        System.out.println("Compras Realizadas: \n");
        Collections.sort(cartaoDeCredito.getProdutos());
        for (Produto p : cartaoDeCredito.getProdutos()) {
            System.out.println(p.getDescricao() + " - " + p.getValor());
        }
        System.out.println("\n--------------------------------------------");

        System.out.println("\nSaldo do cartão: " + cartaoDeCredito.getSaldo());
    }
}
