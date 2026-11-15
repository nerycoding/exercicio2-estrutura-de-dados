package ink.lucasnsnt.exercicio2estruturadedados.controller;

import ch.qos.logback.core.model.Model;
import ink.lucasnsnt.exercicio2estruturadedados.service.ProcessamentoEmpresaService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class EmpresaController {

    private final ProcessamentoEmpresaService processamento;

    public EmpresaController(ProcessamentoEmpresaService processamento) {
        this.processamento = processamento;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/processar")
    public ResponseEntity<Resource> processar(@RequestParam("arquivo") MultipartFile arquivo ) throws IOException {

        processamento.processarArquivo(arquivo.getInputStream());

        Resource txt = new FileSystemResource("empresa-ordenada.txt");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"empresa-ordenada.txt\"")
                .body(txt);

    }



}
