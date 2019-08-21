package CreateUrls.Services;

import CreateUrls.Models.Diagram;
import DTO.DiagramResult;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by Puja on 19/08/19.
 */
@Service
public interface DiagramService {

    public ResponseEntity<Diagram> getDiagram() throws Exception;
    public Diagram getDiagramDetails() throws Exception ;
    public ResponseEntity<List<DiagramResult>> getSerachResult(String str) throws Exception;


}
