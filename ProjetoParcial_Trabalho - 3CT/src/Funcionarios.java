import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existente.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirFuncionario(List<String[]> listaFun) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionario... //Insira seu código aqui")) {
            for (String[] s : listaFun){
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.setString(3, s[2]);
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
        }
    }

    public void lerFuncionario(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario... //Insira seu código aqui ")) {
            selectStatement.setString(1, nomeQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Funcionários");
            String nome = resultSet.getString("nome");
            int telefone = resultSet.getInt("telefone");
            String dataCont = resultSet.getString("contratação");
            System.out.println("nome: "+ nome + ",telefone: " + telefone + ",contratação: " + dataCont);

        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deleteFuncionario(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario... //Insira seu código aqui")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }
}
