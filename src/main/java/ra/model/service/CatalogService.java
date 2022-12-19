package ra.model.service;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogService {
    public List<Catalog> findAll();
    public Catalog findById(int catalogId);
    public boolean save(Catalog ct);
    public boolean update(Catalog ct);
    public boolean delete(int catalogId);
    public List<Catalog> search(String name);
}
