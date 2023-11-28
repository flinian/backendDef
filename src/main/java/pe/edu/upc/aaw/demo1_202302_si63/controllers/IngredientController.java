package pe.edu.upc.aaw.demo1_202302_si63.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.DessertDTO;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.IngredientDTO;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.QuantityIngredientsDTO;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Ingredient;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IIngredientService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes")
public class IngredientController {
    @Autowired
    private IIngredientService iS;

    @PostMapping
    public void registrar(@RequestBody IngredientDTO dto) {
        ModelMapper m = new ModelMapper();
        Ingredient i = m.map(dto, Ingredient.class);
        iS.insert(i);
    }

    @GetMapping
    public List<IngredientDTO> listar() {
        return iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IngredientDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/order/{id}")
    public List<IngredientDTO> Order(@PathVariable("id") String  id) {
        return iS.order(Integer.parseInt(id)).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IngredientDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidades")
    public List<QuantityIngredientsDTO> calcular(){
        List<String[]>lista=iS.quantity();
        List<QuantityIngredientsDTO> lista2=new ArrayList<>();
        for(String[] data: lista){
            QuantityIngredientsDTO dto=new QuantityIngredientsDTO();
            dto.setNameDessert(data[0]);
            dto.setQuantityIngredients(Integer.parseInt(data[1]));
            lista2.add(dto);
        }
        return lista2 ;
    }

    @PutMapping
    public void modificar(@RequestBody IngredientDTO dto){
        ModelMapper m=new ModelMapper();
        Ingredient r= m.map(dto,Ingredient.class);
        iS.insert(r);
    }

    @GetMapping("/{id}")
    public IngredientDTO listarId(@PathVariable("id") int  id) {
        ModelMapper m=new ModelMapper();
        IngredientDTO dto=m.map(iS.listarId(id),IngredientDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){iS.delete(id);}

}
