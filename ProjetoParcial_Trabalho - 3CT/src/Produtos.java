import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Produtos {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existente.");


        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirProdutos(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto... //Insira seu código aqui")) {
            for (String[] s : lista){
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.setString(3, s[2]);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void lerProduto(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Produto... //Insira seu código aqui")) {
            selectStatement.setString(1, nomeQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Produtos");
            String nomePro = resultSet.getString("nome");
            int valor = resultSet.getInt("telefone");
            int quantidade = resultSet.getInt("quantidade");
            System.out.println("nome: "+ nomePro + ",valor: " + valor + ",quantidade: " + quantidade);

        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }

    public void deleteProduto(String nomePro) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto... //Insira seu código aqui")) {
            deleteStatement.setString(1, nomePro);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produtos: " + e.getMessage());
        }
    }
}
