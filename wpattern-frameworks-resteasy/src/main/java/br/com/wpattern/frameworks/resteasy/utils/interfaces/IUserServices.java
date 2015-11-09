package br.com.wpattern.frameworks.resteasy.utils.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.wpattern.frameworks.resteasy.utils.ServiceName;
import br.com.wpattern.frameworks.resteasy.utils.beans.UserBean;

@Path(ServiceName.USER_SERVICE)
@Produces(MediaType.APPLICATION_JSON)//Content-Type:application/json
@Consumes(MediaType.APPLICATION_JSON)//Content-Type:application/json
public interface IUserServices {

	@GET
	public List<UserBean> findAll();

	@POST
	public UserBean add(UserBean user);

	@PUT
	public void update(UserBean user);

	@DELETE
	public UserBean delete(UserBean user);

}
