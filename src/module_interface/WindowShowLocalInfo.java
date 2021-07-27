package module_interface;

import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowShowLocalInfo
{
	//Janela atual
	private JFrame janela;
	
	//Layout da p�gina
	private SpringLayout layout;
	
	//Componente da p�gina (utilizando somente um para facilitar)
	private Container contentPane;
	
	//Tamanho horizontal da janela.
	private int xSize = 1200;
	
	//Tamanho vertical da janela.
	private int ySize = 700;
	
	//Offset horizontal entre os valores da primeira e da segunda coluna.
	private int horizontalDataOffsetValues = 500;
	
	//Offset vertical entre informa��es de uma linha para outra.
	private int vericalDataOffsetValues = 60;
	
	//Offset horizontal dos valores em rela��o ao lado esquerdo da janela.
	private int horizontalWindowOffsetValues = 165;
	
	//Offset vertical dos valores em rela��o � janela.
	private int verticalWindowOffsetValues = 250;
	
	//Fonte de todos os textos da tela.
	private String font = "Arial";
	
	//Tamanho da fonte do t�tulo principal.
	private int sizeMainTitleFont = 50;
	
	//Tamanho da fonte dos valores apresentados na tela.
	private int sizeValueFont = 20;
	
	//Tamanho da fonte do texto dos bot�es.
	private int sizeButtonFont = 25;
	
	
	private void createMainTitleInScreen(String title)
	{
		JLabel labelTitulo = new JLabel(title);
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
	}
	
	/*
	 * Cria na tela o t�tulo da informa��o buscada e o seu correspondente valor
	 * levando em considera��o a linha e a coluna desejada.
	 */
	private void createInfoInScreen(String title, String value, int linha, int coluna)
	{
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(new Font(font, Font.BOLD, sizeValueFont));
		layout.putConstraint(SpringLayout.WEST, labelTitle, horizontalWindowOffsetValues + (coluna - 1)*horizontalDataOffsetValues, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitle, verticalWindowOffsetValues + (linha - 1)*vericalDataOffsetValues, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitle);
		
		JLabel labelValue = new JLabel(value);
		labelValue.setFont(new Font(font, Font.PLAIN, sizeValueFont));
		layout.putConstraint(SpringLayout.WEST, labelValue, 0, SpringLayout.EAST, labelTitle);
		layout.putConstraint(SpringLayout.NORTH, labelValue, 0, SpringLayout.NORTH, labelTitle);
		contentPane.add(labelValue);
	}
	
	public WindowShowLocalInfo(String[] infos)
	{
		//TODO ajustar String[] infos
		janela = new JFrame("Informa��es de " + infos[0]);
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		
		//T�TULO DA JANELA
		createMainTitleInScreen("Informa��es de " + infos[0]);
		
		
		//MOSTRANDO OS VALORES!
		//TODO Mudar para obter valores do registro local
		
		//PRIMEIRA COLUNA
		String titleName = "Nome: ";
		String valueName = infos[0];
		createInfoInScreen(titleName, valueName, 1, 1);
		
		String titleCPF = "CPF: ";
		String valueCPF = infos[1];
		createInfoInScreen(titleCPF, valueCPF, 2, 1);
		
		String titleMotherName = "Nome da m�e: ";
		String valueMotherName = infos[6];
		createInfoInScreen(titleMotherName, valueMotherName, 3, 1);
		
		String titleStatusPerson = "Tipo de caso: ";
		String valueStatusPerson = infos[3];
		createInfoInScreen(titleStatusPerson, valueStatusPerson, 4, 1);
		
		
		//SEGUNDA COLUNA
		String titleGender = "G�nero: ";
		String valueGender = infos[2];
		createInfoInScreen(titleGender, valueGender, 1, 2);
		
		String titleBirthDate = "Data de nascimento: ";
		String valueBirthDate = infos[5];
		createInfoInScreen(titleBirthDate, valueBirthDate, 2, 2);
		
		String titleVaccinationGroup = "Grupo de Atendimento: ";
		String valueVaccinationGroup = infos[4];
		createInfoInScreen(titleVaccinationGroup, valueVaccinationGroup, 3, 2);
		
		
		//BOT�ES
		JButton buttonMainMenu = new JButton("Voltar ao menu principal");
		buttonMainMenu.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.EAST, buttonMainMenu, -50, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, buttonMainMenu, -50, SpringLayout.SOUTH, contentPane);
		buttonMainMenu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new WindowMain();
		    	janela.setVisible(false);
		    	janela.dispose();
		    }
		});
		contentPane.add(buttonMainMenu);
		
		JButton buttonNewSearch = new JButton("Fazer nova consulta");
		buttonNewSearch.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.EAST, buttonNewSearch, -50, SpringLayout.WEST, buttonMainMenu);
		layout.putConstraint(SpringLayout.SOUTH, buttonNewSearch, 0, SpringLayout.SOUTH, buttonMainMenu);
		buttonNewSearch.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowSearchLocalInfo();
		    }
		});
		contentPane.add(buttonNewSearch);
		
		
		contentPane.setLayout(layout);
		janela.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		String[] infos = new String[7];
		infos[0] = "Nome";
		infos[1] = "CPF";
		infos[2] = "G�nero";
		infos[3] = "Status";
		infos[4] = "Grupo";
		infos[5] = "Data de nascimento";
		infos[6] = "Nome da m�e";
		
		new WindowShowLocalInfo(infos);
	}
}