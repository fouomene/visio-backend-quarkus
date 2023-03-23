package com.fouomene.device.resource;

import com.fouomene.device.exception.OneLogicBusinessException;
import com.fouomene.device.service.DeviceService;
import com.fouomene.device.model.dto.DeviceDto;
import com.fouomene.device.resource.response.StatusDeviceResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/visio/devices")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@AllArgsConstructor
public class DeviceResource {

    private final Logger log = LoggerFactory.getLogger(DeviceResource.class);

    private final DeviceService deviceService;

    @POST
    @Path("/create")
    public DeviceDto createDevice(@Valid DeviceDto deviceDtoRequest) throws OneLogicBusinessException {
        log.info("enregistrer-materiel");
        return deviceService.createDevice(deviceDtoRequest);
    }

    @PUT
    @Path("/update")
    public DeviceDto updateDevice(@Valid DeviceDto deviceDtoRequest) throws OneLogicBusinessException {
        log.info("mise-à-jour-materiel");
        return deviceService.updateDevice(deviceDtoRequest);
    }


    @GET
    @Path("/getall")
    public List<DeviceDto> getAllDevices() {
        log.info("liste-materiel");
        return deviceService.getAllDevices();
    }

    @GET
    @Path("/delete/{code}")
    public Response deleteDeviceByCode(@PathParam("code") String code) throws OneLogicBusinessException {
        log.info("supprimer-materiel");
        deviceService.deleteDeviceByCode(code);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public DeviceDto getDeviceById(@PathParam("id") long id) throws OneLogicBusinessException {
        System.out.println(deviceService.findDeviceById(Long.valueOf(id)));
        return deviceService.findDeviceById(id);
    }

    @GET
    @Path("/status/{code}")
    public StatusDeviceResponse getStatusDeviceByCode(@PathParam("code") String code) throws OneLogicBusinessException {
        return StatusDeviceResponse.builder()
                .status(deviceService.getStatusDeviceByCode(code))
                .build();
    }

    @GET
    @Path("/initdb")
    public List<DeviceDto> initDb() {
        return deviceService.initDb();
    }


}