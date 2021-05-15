package tn.esprit.spring.controller;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.service.IEventService;

import java.util.List;
//@Scope (value = "session")

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@Scope (value = "session")
@Component (value = "eventList")
@ELBeanName(value = "eventList")
@Join(path = "/", to = "/event-list.jsf")
public class EventListController implements IEventListController{
	private List<Event> events;
	
	@Autowired
	IEventService iEventService;
	@Deferred
	@RequestAction
	@IgnorePostback
    public void loadData() {
        iEventService.loadData();
    }
    public List<Event> getEvents() {
    	events=iEventService.getEvents();
        return events;
    }
}