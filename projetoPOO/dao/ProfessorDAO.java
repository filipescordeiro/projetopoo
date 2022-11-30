/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d156.projetoPOO.dao;

import com.d156.projetoPOO.model.Aluno;
import com.d156.projetoPOO.model.Professor;
import com.d156.projetoPOO.utils.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucme
 */
public class ProfessorDAO {

    // Insere os valores na tabela clientes.
    public static boolean salvar(Professor obj) {
        boolean retorno = false;
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("insert into Professor (nome,idade,dataNascimento,CPF,sexo,estadocivil,endereco,cidade,bairro,estado,numero,cep,telefone,salario) \n" +
"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, obj.getNome());
            sql.setInt(2, obj.getIdade());
            sql.setString(3, obj.getDataNascimento());
            sql.setString(4, obj.getCPF());
            sql.setString(5, obj.getSexo());
            sql.setString(6, obj.getEstadocivil());
            sql.setString(7, obj.getEndereco());
            sql.setString(8, obj.getCidade());
            sql.setString(9, obj.getBairro());
            sql.setString(10, obj.getEstado());
            sql.setString(11, obj.getNcasa());
            sql.setString(12, obj.getCEP());
            sql.setString(13, obj.getTelefone());
            sql.setDouble(14, obj.getSalario());

            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possível inserir o cliente");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    // Consulta o cliente utilizando o cpf como parâmetro.
    public static Professor consultarProfessor(Professor obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where cpf=?");
            sql.setString(1, obj.getCPF());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProfessor(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNcasa(rs.getString("numero"));
                obj.setSexo(rs.getString("genero"));
                obj.setEstadocivil(rs.getString("estadoCivil"));
                obj.setDataNascimento(rs.getString("dataNascimento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCEP(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar o Cliente!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return obj;
    }

    // Retorna um objeto preenchido a partir de um id.
    public static Professor consultarProfessorId(Professor obj) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where idAluno=?");
            sql.setInt(1, obj.getIdProfessor());
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProfessor(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNcasa(rs.getString("numero"));
                obj.setSexo(rs.getString("genero"));
                obj.setEstadocivil(rs.getString("estadoCivil"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setDataNascimento(rs.getString("dataNascimento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCEP(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar o Cliente!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return obj;
    }

    // Listagem dos clientes sem parâmetros.
    public static ArrayList<Professor> listaProfessor(Professor obj) {
        Connection conexao = null;
        ArrayList<Professor> listaRetorno = new ArrayList<Professor>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from clientes");
            rs = sql.executeQuery();
            while (rs.next()) {
                obj.setIdProfessor(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNcasa(rs.getString("numero"));
                obj.setSexo(rs.getString("genero"));
                obj.setEstadocivil(rs.getString("estadoCivil"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setDataNascimento(rs.getString("dataNascimento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCEP(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                listaRetorno.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }

    // Listatem dos clientes por nome, sendo utilizada em um evento de "key typed".
    public static ArrayList<Professor> listaAlunoNome(Professor obj) {
        Connection conexao = null;
        ArrayList<Professor> listaRetorno = new ArrayList<Professor>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from professor where nome like ?");
            sql.setString(1, '%' + obj.getNome() + '%');
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new Professor();
                obj.setIdProfessor(rs.getInt("idProfessor"));
                obj.setNome(rs.getString("nome"));
                obj.setIdade(rs.getInt("idade"));
                obj.setDataNascimento(rs.getString("dataNascimento"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setEstadocivil(rs.getString("estadoCivil"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setEstado(rs.getString("estado"));
                obj.setNcasa(rs.getString("numero"));
                obj.setCEP(rs.getString("cep"));
                obj.setTelefone(rs.getString("telefone"));
                listaRetorno.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage() + "Aqui!!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }

    // Listatem dos clientes por cpf, sendo utilizada em um evento de "key typed".
    public static ArrayList<Professor> listaProfessorCpf(Professor obj) {
        Connection conexao = null;
        ArrayList<Professor> listaRetorno = new ArrayList<Professor>();
        ResultSet rs = null;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("Select * from clientes where cpf like ?");
            sql.setString(1, '%' + obj.getCPF()+ '%');
            rs = sql.executeQuery();
            while (rs.next()) {
                obj = new Professor();
                obj.setIdProfessor(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNcasa(rs.getString("numero"));
                obj.setSexo(rs.getString("genero"));
                obj.setEstadocivil(rs.getString("estadoCivil"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setDataNascimento(rs.getString("dataNascimento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCEP(rs.getString("cep"));
                obj.setEstado(rs.getString("estado"));
                listaRetorno.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }

    // Exclui um cadastro utilizando o id como parâmetro.
    public static boolean excluir(Professor obj) {
        Connection conexao = null;
        boolean retorno = false;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("delete from clientes where idCliente=?");
            sql.setInt(1, obj.getIdProfessor());
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir o cliente!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return retorno;
    }

    // Altera um cadastro utilizando o id como parâmetro.
    public static boolean atualizar(Professor obj) {
        Connection conexao = null;
        boolean retorno = false;
        try {
            conexao = ConexaoFactory.getConexao();
            PreparedStatement sql = conexao.prepareStatement("update professor set nome=?,idade=?,dataNascimento=?,sexo=?,estadoCivil=?,endereco=?,cidade=?,bairro=?,estado=?,numero=?,cep=?,telefone =?,salario=? where cpf =?");
            sql.setString(1, obj.getNome());
            sql.setInt(2, obj.getIdade());
            sql.setString(3, obj.getDataNascimento());
            sql.setString(4, obj.getSexo());
            sql.setString(5, obj.getEstadocivil());
            sql.setString(6, obj.getEndereco());
            sql.setString(7, obj.getCidade());
            sql.setString(8, obj.getBairro());
            sql.setString(9, obj.getEstado());
            sql.setString(10, obj.getNcasa());
            sql.setString(11, obj.getCEP());
            sql.setString(12, obj.getTelefone());
            sql.setDouble(13, obj.getSalario());
            sql.setString(14, obj.getCPF());


            
            int linhasAfetadas = sql.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar!");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return retorno;
    }
}
