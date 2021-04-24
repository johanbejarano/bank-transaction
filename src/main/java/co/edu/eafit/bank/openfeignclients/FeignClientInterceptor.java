package co.edu.eafit.bank.openfeignclients;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FeignClientInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		
		//Url capturada
		String url = template.url();
		
		log.info("Capturando petición a " + url);
		
		//Setting header
		template.header("myHeader", "My Value");
		
		//Reading headers
		Map<String, Collection<String>> headers = template.headers();
		
		headers.forEach((key, values) -> {
			values.forEach(value -> {
				log.info("Key: " + key + ". Value: " + value);
			});
		});
		
	}

}
