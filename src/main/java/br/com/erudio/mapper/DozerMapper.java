package br.com.erudio.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {	//Parse one type object to another type object type		Two types of objects: O = origin, D = destination.	<O, D>	in the start of the function, means a function who can receive any type of data   
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {	//Is like the .map in Next/React
			destinationObjects.add(mapper.map(o, destination));
		}
		
		return destinationObjects;
	}
}