package com.quixada.sme.sape.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.quixada.sme.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quixada.sme.dao.AvaliacaoDAO;
import com.quixada.sme.dao.EscolaDAO;
import com.quixada.sme.model.Escola;
import com.quixada.sme.model.Nivel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RelatorioController {
	private static final int periodo1 = 1;
	private static final int periodo2 = 2;
	private static final int periodo3 = 3;
	private static final int periodo4 = 4;

	private static final String PAG_RELATORIO = "pclei/pagRelatorio";
	//private static final String PAG_HOME = "redirect:home";
	
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;
	@Autowired
	private EscolaDAO escolaDao;
	
	@RequestMapping(value = "/pclei/gerarRelatorio", method = {RequestMethod.POST, RequestMethod.GET} )
	public String getRelatorio(RedirectAttributes redirect, HttpServletRequest request){
		
		HttpSession session = request.getSession();

		int idEscola = -69;
		//int idRegional = (int)session.getAttribute("regional.id");
		try {
			idEscola = (int) session.getAttribute("idEscola");
		}
		catch (NullPointerException e){
		    redirect.addFlashAttribute("erro","desculpe, não é possivel exibir o relatório para este usuário.");
            if(((Usuario)session.getAttribute("usuario")).getIsAdmin()==1) {
                return "redirect:/";
            }
            else{
                return "redirect:/";
            }
		}
		Escola escola;
		try {
			escola = escolaDao.getEscolasPorID(idEscola);
			session.setAttribute("nomeEscola", escola.getNome());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int resPeriodoPreSilabico1 = 0;
		int resPeriodoSilabico1 = 0;
		int resPeriodoSilabicoAlfa1 =0;
		int resPeriodoAlfabetico1  = 0;
		int resPeriodoOrtografico1  = 0;
		
		int resPeriodoPreSilabico2 = 0;
		int resPeriodoSilabico2  = 0;
		int resPeriodoSilabicoAlfa2  = 0;
		int resPeriodoAlfabetico2  = 0;
		int resPeriodoOrtografico2 = 0;
		
		int resPeriodoPreSilabico3 = 0;
		int resPeriodoSilabico3 = 0;
		int resPeriodoSilabicoAlfa3  = 0;
		int resPeriodoAlfabetico3  = 0;
		int resPeriodoOrtografico3  = 0;
		
		int resPeriodoPreSilabico4  = 0;
		int resPeriodoSilabico4  = 0;
		int resPeriodoSilabicoAlfa4  = 0;
		int resPeriodoAlfabetico4  = 0;
		int resPeriodoOrtografico4  = 0;
		
		//pegando dados por escola
		try {
			 resPeriodoPreSilabico1 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo1, Nivel.PRE_SILABICO);
			 resPeriodoSilabico1 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo1, Nivel.SILABICO);
			 resPeriodoSilabicoAlfa1 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo1, Nivel.SILABICO_ALFABETICO);
			 resPeriodoAlfabetico1 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo1, Nivel.ALFABETICO_ORTOGRAFICO);
			 resPeriodoOrtografico1 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo1, Nivel.ORTOGRAFICO);
			
//			 resPeriodoPreSilabico2 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo2,1);
//			 resPeriodoSilabico2 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo2, 2);
//			 resPeriodoSilabicoAlfa2 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo2, 3);
//			 resPeriodoAlfabetico2 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo2, 4);
//			 resPeriodoOrtografico2 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo2, 5);
//			
//			 resPeriodoPreSilabico3 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo3, 1);
//			 resPeriodoSilabico3 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo3, 2);
//			 resPeriodoSilabicoAlfa3 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo3, 3);
//			 resPeriodoAlfabetico3 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo3, 4);
//			 resPeriodoOrtografico3 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo3, 5);
//			
//			 resPeriodoPreSilabico4 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo4, 1);
//			 resPeriodoSilabico4 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo4, 2);
//			 resPeriodoSilabicoAlfa4 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo4, 3);
//			 resPeriodoAlfabetico4 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo4, 4);
//			 resPeriodoOrtografico4 = avaliacaoDAO.resultAvaliacaoPorPeriodo(idEscola, periodo4, 5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] vetPeriodo1 = new int[6];
		  vetPeriodo1[1] =   resPeriodoPreSilabico1;
		  vetPeriodo1[2] =   resPeriodoSilabico1;
		  vetPeriodo1[3] =   resPeriodoSilabicoAlfa1;
		  vetPeriodo1[4] =   resPeriodoAlfabetico1;
		  vetPeriodo1[5] =   resPeriodoOrtografico1;
		  
		int[] vetPeriodo2 = new int[6];
			  vetPeriodo2[1] =   resPeriodoPreSilabico2;
			  vetPeriodo2[2] =   resPeriodoSilabico2;
			  vetPeriodo2[3] =   resPeriodoSilabicoAlfa2;
			  vetPeriodo2[4] =   resPeriodoAlfabetico2;
			  vetPeriodo2[5] =   resPeriodoOrtografico2;
			  
		int[] vetPeriodo3 = new int[6];
				  vetPeriodo3[1] =   resPeriodoPreSilabico3;
				  vetPeriodo3[2] =   resPeriodoSilabico3;
				  vetPeriodo3[3] =   resPeriodoSilabicoAlfa3;
				  vetPeriodo3[4] =   resPeriodoAlfabetico3;
				  vetPeriodo3[5] =   resPeriodoOrtografico3;
				  
		int[] vetPeriodo4 = new int[6];
				  vetPeriodo4[1] =   resPeriodoPreSilabico4;
				  vetPeriodo4[2] =   resPeriodoSilabico4;
				  vetPeriodo4[3] =   resPeriodoSilabicoAlfa4;
				  vetPeriodo4[4] =   resPeriodoAlfabetico4;
				  vetPeriodo4[5] =   resPeriodoOrtografico4;
		
		session.setAttribute("vetPeriodo1", vetPeriodo1);
		session.setAttribute("vetPeriodo2", vetPeriodo2);
		session.setAttribute("vetPeriodo3", vetPeriodo3);
		session.setAttribute("vetPeriodo4", vetPeriodo4);
		

		return PAG_RELATORIO;	
	}
}
