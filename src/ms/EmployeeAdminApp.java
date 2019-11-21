package ms;

public class EmployeeAdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeRequest[] requests = {
										new EmployeeRequest("E045", 1, 2),
										new EmployeeRequest("E025", 2, 3),
										new EmployeeRequest("E001", 1, 2),
										new EmployeeRequest("E035", 2, 1),
										new EmployeeRequest("E005", 3, 1),
										new EmployeeRequest("E003", 4, 5)
									};
		
		EmployeeRequest[] requests2 = {
				new EmployeeRequest("E001", 1, 2),
				new EmployeeRequest("E657", 2, 1),
				new EmployeeRequest("E085", 1, 2),
				new EmployeeRequest("E012", 2, 3),
				new EmployeeRequest("E023", 3, 1),
				new EmployeeRequest("E079", 4, 5)
		};
		
		  
		
		  String[][] servedReqs= serveEmployeeRequests(requests2);
		  
		  //Printing served requests
		  for(int i =0; i<servedReqs.length; i++) { 
		  for(int j=0; j<servedReqs[i].length; j++) { if(servedReqs[i][j] !=null)System.out.print(servedReqs[i][j] +" "); }
		  	System.out.println("");
		  }
		 
		
	}
	
	public static String[][] serveEmployeeRequests(EmployeeRequest[] requests){
		String[][] listOfEmployees = new String[requests.length][requests.length];
		int index =0;
		
		for(int i =0; i<requests.length; i++) 
		{
			EmployeeRequest r = requests[i];
			
			if(r.isReqServed())
				continue;
			
				int index2 = 0;
				EmployeeRequest[] matchedReq= new EmployeeRequest[requests.length];
				boolean isCyclic = false;
				int rTo = r.getBuildingTo();
				for(int j=0; j<requests.length; j++)
				{
					EmployeeRequest r2 = requests[j];
					if(r2.isReqServed() || r.getId().equals(r2.getId()))
						continue;
					
					if(r.getBuildingTo() == r2.getBuildingFrom() && r.getBuildingFrom() == r2.getBuildingTo()) {
							r.setReqServed(true);
							r2.setReqServed(true);
							String[] empXchgPair = {r.getId(),r2.getId()};
							listOfEmployees[index]=empXchgPair;
							index++;
							
							
							break;
					}
					else if(rTo == r2.getBuildingFrom()) {
						matchedReq[index2++]= r2;
						rTo = r2.getBuildingTo();
						
						if(r2.getBuildingTo()==r.getBuildingFrom()) {
							matchedReq[index2++]= r;
							isCyclic = true;
							break;
						}
					}
				}
				
				if(isCyclic) {
					for(int k=0; k<matchedReq.length; k++) {
						if(matchedReq[k]!=null) {
							matchedReq[k].setReqServed(true);
							listOfEmployees[index][k]= matchedReq[k].getId();
						}
						
					}
					index++;
				}
				
		}
		
		return listOfEmployees;
	}

}
