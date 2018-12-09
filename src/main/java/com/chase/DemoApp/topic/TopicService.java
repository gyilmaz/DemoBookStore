package com.chase.DemoApp.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

   private List<Topic> topics=  new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring framework", "Spring Framework Description"),
            new Topic("java","Java 8 OCA", "Java 8 Description"),
            new Topic("javascript","React and Redux"," Javascript description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t-> t.getId().equalsIgnoreCase(id)).findFirst().get();
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i <topics.size() ; i++) {
            if(topics.get(i).getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(Topic topic, String id) {
        topics.removeIf(t-> t.getId().equals(id));
//        for (int i = 0; i <topics.size() ; i++) {
//            if(topics.get(i).getId().equals(id)){
//                topics.remove(i);
//                return;
//            }
//        }
    }
}
