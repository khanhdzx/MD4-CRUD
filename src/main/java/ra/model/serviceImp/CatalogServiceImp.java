package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.CatalogDao;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;
@Service
public class CatalogServiceImp implements CatalogService {
    @Autowired
    private CatalogDao catalogDao;
    @Override
    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    @Override
    public Catalog findById(int catalogId) {
        return catalogDao.findById(catalogId);
    }

    @Override
    public boolean save(Catalog ct) {
        return catalogDao.save(ct);
    }

    @Override
    public boolean update(Catalog ct) {
        return catalogDao.update(ct);
    }

    @Override
    public boolean delete(int catalogId) {
        return catalogDao.delete(catalogId);
    }

    @Override
    public List<Catalog> search(String name) {
        return catalogDao.search(name);
    }
}
