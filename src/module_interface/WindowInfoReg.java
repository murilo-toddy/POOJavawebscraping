package module_interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import local_database.RegistersHandler;
import module_exceptions.RegisterExistsException;

public class WindowInfoReg  {

	//Janela atual
	private JFrame janela;
	
    public WindowInfoReg() {
        
        // criando as variaveis
    	this.janela = new JFrame("Cadastro de Informações");

        Container contentPane = janela.getContentPane();
        SpringLayout layout = new SpringLayout();
        JLabel titulo = new JLabel("Cadastro de Informações");
        
        JButton buttonReg = new JButton("Cadastrar");
        JButton buttonCancel = new JButton("Cancelar");
        
        JLabel labelCaseType = new JLabel("Tipo de Caso");
        JTextField caseType = new JTextField(20);
        
        JLabel labelName = new JLabel("Nome");
        JTextField name = new JTextField(40);
        
        JLabel labelGender = new JLabel("Sexo");
        JTextField gender = new JTextField(20);
        
        JLabel labelCPF = new JLabel("CPF (Apenas números)");
        JTextField cpf = new JTextField(20);
        
        JLabel labelbirthDate = new JLabel("Data de Nascimento");
        JTextField birthDate = new JTextField(20);
        
        JLabel labelattGroup = new JLabel("Grupo de Atendimento");
        JTextField attGroup = new JTextField(20);
        
        JLabel labelmotherName = new JLabel("Nome da Mãe");
        JTextField motherName = new JTextField(40);

        // titulo
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(titulo);
        janela.setSize(1200, 700);
        
        // campos de texto
        layout.putConstraint(SpringLayout.WEST, labelCaseType, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelCaseType, 165, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, caseType, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, caseType, 165 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelName, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, name, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelGender, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelGender, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, gender, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, gender, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelCPF, 100 + 800, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelCPF, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, cpf, 100 + 800, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, cpf, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelbirthDate, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelbirthDate, 165 + 120, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, birthDate, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, birthDate, 165 + 120 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelattGroup, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelattGroup, 165 + 120, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, attGroup, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, attGroup, 165 + 120 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelmotherName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelmotherName, 165 + 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, motherName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, motherName, 165 + 180 + 20, SpringLayout.NORTH, contentPane);
        
        // bot�es
        buttonReg.setFont(new Font("Arial", Font.BOLD, 25));
        buttonReg.addActionListener(new ActionListener() {
		    
        	@Override
		    public void actionPerformed(ActionEvent e) {
        		RegistersHandler reg = null;
        		
        		try {
        			reg = new RegistersHandler();
        		}
        		catch(Exception exc) {
        			new WindowError("Não é possível acessar as informações locais!");
        		}
		    	
		    	String[] infos = new String[7];
		    	infos[0] = name.getText();
		    	infos[1] = cpf.getText();
		    	infos[2] = gender.getText();
		    	infos[3] = caseType.getText();
		    	infos[4] = attGroup.getText();
		    	infos[5] = birthDate.getText();
		    	infos[6] = motherName.getText();
		    	
		    	boolean anyEmptyField = false;
		    	for(int i = 0; i < infos.length; i++) {
		    		if(infos[i].isEmpty())
		    		{
		    			anyEmptyField = true;
		    		}
		    	}
		    	
		    	if(anyEmptyField) {
		    		new WindowError("Preencha todos os campos!");
		    	}
		    	
		    	//Verificação tipo de caso
		    	else if(!infos[3].equals(RegistersHandler.deathStatus) && !infos[3].equals(RegistersHandler.caseStatus) &&
		    			!infos[3].equals(RegistersHandler.vaccinatedStatusFirstDose) &&
		    			!infos[3].equals(RegistersHandler.vaccinatedStatusSecondDose) && 
		    			!infos[3].equals(RegistersHandler.vaccinatedStatusOnlyDose)) {
		    		
		    		String possibleOptions = RegistersHandler.deathStatus + " / " + RegistersHandler.caseStatus + 
		    				" / " + RegistersHandler.vaccinatedStatusFirstDose + " / " + RegistersHandler.vaccinatedStatusSecondDose
		    				+ " / " + RegistersHandler.vaccinatedStatusOnlyDose;
		    		
		    		new WindowError("Insira um Tipo de Caso válido!", possibleOptions);
		    	}
		    	
		    	//Verificação sexo
		    	else if(!infos[2].equals(RegistersHandler.maleSex) && !infos[2].equals(RegistersHandler.femaleSex)) {
		    		String possibleOptions = RegistersHandler.maleSex + " / " + RegistersHandler.femaleSex;
		    		new WindowError("Insira um Sexo válido!", possibleOptions);
		    	}
		    	
		    	//Verificação grupo de atendimento
		    	else if(!infos[4].equals(RegistersHandler.prioritaryGroup) && 
		    			!infos[4].equals(RegistersHandler.mediumGroup) && !infos[2].equals(RegistersHandler.lastGroup)) {
		    		
		    		String possibleOptions = RegistersHandler.prioritaryGroup + " / " + 
		    				RegistersHandler.mediumGroup + " / " + RegistersHandler.lastGroup;
		    		new WindowError("Insira um Grupo de Atendimento válido!", possibleOptions);
		    	}
		    	
		    	//Verificação da data de nascimento
		    	else if(!checkValidBirthDate(infos[5])) {
		    		new WindowError("Insira uma data de nascimento válida!", "DD/MM/AAAA");
		    	}
		    	
		    	//Verificação do CPF
		    	else if(!checkValidCPF(infos[1])) {
		    		new WindowError("Insira um CPF válido!", "Este programa verifica se o CPF é válido");
		    	}
		    	
		    	else
		    	{
		    		try {
			    		reg.registerNewCase(infos);
			    		
			    		janela.setVisible(false);
			    		janela.dispose();
			    		new WindowSucess("Cadastro realizado com sucesso!");
			    		
			    	}
		    		catch(IOException ioExc)
		    		{
		    			new WindowError("Não é possível acessar as informações locais!");
		    		}
			    	catch(RegisterExistsException existExc) {
		                Object[] options = {"Sim", "Não", "Cancelar"};
		                JOptionPane op = new JOptionPane();
		                op.setSize(600, 300);
		                int input = JOptionPane.showOptionDialog(null, "Atualizar Cadastro?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION,
		                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		                switch (input) {
		                    case JOptionPane.OK_OPTION:
								try {
									reg.updateInformation(infos);
									janela.setVisible(false);
						    		janela.dispose();
									new WindowSucess("Atualizado com sucesso!");
								} catch (Exception InfoExc) {
									new WindowError("Não é possível acessar as informações locais!");
								}                	
		                        break;
		                    case JOptionPane.CANCEL_OPTION:
		                        op.setVisible(false);
		                        break;
		                    default:
		                    	op.setVisible(false);
		                    	janela.setVisible(false);
		                    	janela.dispose();
		                    	new WindowMain();
		                        break;
		                }
			    	}
		    	}
		    	
		    
		    	
		    	
		    }
		});
        
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 25));
        buttonCancel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowMain();
		    }
		});
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonReg, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonReg, 450, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCancel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonCancel, 500, SpringLayout.NORTH, contentPane);
        
        // adicionando ao painel
        contentPane.add(labelCaseType);
        contentPane.add(caseType);
        contentPane.add(labelName);
        contentPane.add(name);
        contentPane.add(labelGender);
        contentPane.add(gender);
        contentPane.add(labelCPF);
        contentPane.add(cpf);
        contentPane.add(labelbirthDate);
        contentPane.add(birthDate);
        contentPane.add(labelattGroup);
        contentPane.add(attGroup);
        contentPane.add(labelmotherName);
        contentPane.add(motherName);
        contentPane.add(buttonReg);
        contentPane.add(buttonCancel);
        contentPane.setLayout(layout);
        janela.setVisible(true); 
    }  
    
    
    private static boolean checkValidCPF(String cpf) {
        int length = cpf.length();
        if(length != 11)
        	return false;
        try {
            long parse = Long.parseLong(cpf);
        }
        catch(Exception e) {
        	return false;
        }
        int sumFirstDigit = 0, sumSecondDigit = 0;
        for(int i = 0, j = 10; i < length-2; i++, j--) {
            sumFirstDigit += (Character.getNumericValue(cpf.charAt(i)) * j);
        }
        for(int i = 0, j = 11; i < length-1; i++, j--) {
            sumSecondDigit += (Character.getNumericValue(cpf.charAt(i)) * j);
        }
        sumFirstDigit = (sumFirstDigit * 10) % 11; 
        sumSecondDigit = (sumSecondDigit * 10) % 11;

        if(sumFirstDigit == 10)
            sumFirstDigit = 0;
        if(sumSecondDigit == 10)
            sumSecondDigit = 0;

        if(sumFirstDigit == Character.getNumericValue(cpf.charAt(9)) && sumSecondDigit == Character.getNumericValue(cpf.charAt(10)))
            return true;
        else
            return false;
    }
    
    
    private boolean checkValidBirthDate(String date) {
    	int count = 0;
    	for (int index = date.indexOf("/"); index >= 0; index = date.indexOf("/", index + 1)) {
    		count++;
    	}
    	if(count != 2)
    		return false;
    	int day, month, year;
    	try {
    		day = Character.getNumericValue(date.charAt(0)) * 10 + Character.getNumericValue(date.charAt(1));  
    		month = Character.getNumericValue(date.charAt(3)) * 10 + Character.getNumericValue(date.charAt(4));
    		year = Character.getNumericValue(date.charAt(6)) * 1000 + Character.getNumericValue(date.charAt(7)) * 100 + Character.getNumericValue(date.charAt(8)) * 10 + Character.getNumericValue(date.charAt(9));
    	}
    	catch(Exception e) {
    		return false;
    	}
    	if(month < 1 || month > 12) {
    		return false;
    	}
    	if(day < 1)
    		return false;
    	
    	switch(month) {
    	case 1:
    		if(day > 31)
    			return false;
    		break;
    	case 2:
    		if((year % 4 == 0 && day > 29) || (year % 4 != 0 && day > 28))
    			return false;
    		break;
    	case 3:
    		if(day > 31)
    			return false;
    		break;
    	case 5:
    		if(day > 31)
    			return false;
    		break;
    	case 7:
    		if(day > 31)
    			return false;
    		break;
    	case 8:
    		if(day > 31)
    			return false;
    		break;
    	case 10:
    		if(day > 31)
    			return false;
    		break;
    	case 12:
    		if(day > 31)
    			return false;
    		break;
    	default:
    		if(day > 30)
    			return false;
    		break;
    	}
    	return true;
    }
    
    
    public static void main(String[] args){
    	new WindowInfoReg();
    }
}
