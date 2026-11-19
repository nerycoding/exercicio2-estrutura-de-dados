package ink.lucasnsnt.exercicio2estruturadedados.controller;

import ink.lucasnsnt.exercicio2estruturadedados.service.ProcessamentoEmpresaService;
import ink.lucasnsnt.exercicio2estruturadedados.service.ProcessamentoPilotoService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ink.lucasnsnt.exercicio2estruturadedados.enums.TipoProcessamento;

import java.io.IOException;

@Controller
public class ProcessamentoController {

    private final ProcessamentoEmpresaService processamentoEmpresa;

    private final ProcessamentoPilotoService processamentoPiloto;

    public ProcessamentoController(ProcessamentoPilotoService processamentoPiloto, ProcessamentoEmpresaService processamentoEmpresa) {
        this.processamentoPiloto = processamentoPiloto;
        this.processamentoEmpresa = processamentoEmpresa;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @PostMapping("/processar")
    public ResponseEntity<Resource> processar(@RequestParam("arquivo") MultipartFile arquivo,
                                              @RequestParam("tipo") TipoProcessamento tipo ) throws IOException {



        switch (tipo) {
            case EMPRESAS -> {

                processamentoEmpresa.processarArquivo(arquivo.getInputStream());

                Resource txt = new FileSystemResource("empresa-ordenada.txt");

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"empresa-ordenada.txt\"")
                        .body(txt);
            }
            case VOLTAS -> {

                processamentoPiloto.processarArquivo(arquivo.getInputStream());

                Resource txtvoltas = new FileSystemResource("voltas-ordenadas.txt");

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"voltas-ordenadas.txt\"")
                        .body(txtvoltas);
            }
        }

        throw new IllegalArgumentException("Tipo inválido");

    }



}
