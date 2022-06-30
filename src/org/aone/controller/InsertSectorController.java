package org.aone.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.service.ISectorService;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class InsertSectorController{
	
	final  Logger logger = Logger.getLogger(InsertSectorController.class.getName());
	@Autowired
    private ISectorService sectorService;
    
	@RequestMapping(value = "/sectorSignUp", method = RequestMethod.GET)
    public String insertSectorGet(@ModelAttribute("sectorSignUp") SectorMasterVO testBeanVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException {
		
		/*
		SectorListVO sectorListVO=new SectorListVO();
		testBeanVO.setSectorListVO(sectorListVO);
		List<SectorListVO> sectorVOs =sectorService.selectTestTypeList(testBeanVO.getSectorListVO());
		session.setAttribute("sectorVOs", sectorVOs);

*/
		
		

    return "sectorSignUp";
    }


 	@RequestMapping(value = "/sectorSignUp", method = RequestMethod.POST)
    public String  insertSectorPost(@ModelAttribute("sectorSignUp") SectorMasterVO sectorMasterVO,ModelMap map,HttpSession session,HttpServletRequest request) throws UpdateFailedException, DuplicateEntryException  
 	{
 		  
            try {
            	 SectorVO sectorVO=new SectorVO();
                 String testType=request.getParameter("sectorListVO.testType");
                 sectorVO.setTestTypeId(testType);

                 String sector=request.getParameter("sectorListVO.sector");
                 sectorVO.setSector(sector);
                 
                 sectorMasterVO.setSectorVO(sectorVO);
				 Map<String, String> transportName=sectorService.getName();
				 for (Entry<String, String> entry : transportName.entrySet()) {
			            if (entry.getKey().equals(sectorMasterVO.getSectorVO().getTestTypeId())) {
			                sectorMasterVO.getSectorVO().setTestType(entry.getValue());
							 

			            }
			        }
			 sectorService.insertSector(sectorMasterVO.getSectorVO());

			} catch (NoDataFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	return "sectorSignUp";
    }

 
 	@RequestMapping(value = "/sectorSignUp", method = RequestMethod.POST, params = "test")
	public @ResponseBody Map<String, String> getTransport(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		Map<String, String> sector = null;
		try {

			sector=sectorService.getName();
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	

		logger.debug("Transport in Section Map :" + sector);
		return sector;
	}
	   
	
 	     
       
}
