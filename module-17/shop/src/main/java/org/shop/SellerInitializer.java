package org.shop;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * The Seller Initializer util class.
 */
@Component
public class SellerInitializer {

    /** The seller service. */
    private SellerService sellerService;
    
    /** The seller names. */
    @Resource(name="sellersMap")
    private Map<Long, String> sellerNames = Collections.emptyMap();

    /**
     * Inits the sellers.
     */
    public void initSellers() {
        List<Seller> sellers = new LinkedList<Seller>();
        
        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());
            
            sellers.add(seller);
        }
        
        sellerService.importSellers(sellers);
    }
}
