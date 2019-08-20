package CreateUrls.Services;

import CreateUrls.Models.Diagram;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by Puja on 19/08/19.
 */
@Service
public interface DiagramService {

    public ResponseEntity<String> getDiagram() throws Exception;

}
