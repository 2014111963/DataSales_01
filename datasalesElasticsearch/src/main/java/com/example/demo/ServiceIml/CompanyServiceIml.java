package com.example.demo.ServiceIml;

import com.example.demo.Dao.CompanyService;
import com.example.demo.Model.Company;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CompanyServiceIml implements CompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    private JestClient jestClient;

    @Override
    public void saveCompany(Company data){

    }

    @Override
    public void saveCompany(List<Company> dataList){

    }

    /**
     * 根据省市，有无电话，邮箱以及行业分类过滤查询
     * @param Company
     * @return
     */

    protected static QueryBuilder booleanQuery(Company data) {

        return QueryBuilders
                .boolQuery()
                .must(QueryBuilders.termQuery("province", data.getProvince()))
                .must(QueryBuilders.termQuery("city", data.getCity()));
    }

    /**
     * 单个字段皮配
     * @return
     */
    protected static QueryBuilder matchQuery(Company data) {
        return QueryBuilders.matchQuery("city", data.getCity());
    }

    @Override
    public List<Company> searchCompany(Company data){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // BoolQueryBuilder subCodeQuery = QueryBuilders.boolQuery();

        /**
         * 根据条件筛选数据

        WildcardQueryBuilder queryBuilder0 = QueryBuilders.wildcardQuery("province",data.getProvince());
        WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("city",data.getCity());
        WildcardQueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("tel",data.getTel());
        WildcardQueryBuilder queryBuilder3 = QueryBuilders.wildcardQuery("email",data.getEmail());
        WildcardQueryBuilder queryBuilder4 = QueryBuilders.wildcardQuery("productions",data.getProductions());
        subCodeQuery.must(queryBuilder0);
        subCodeQuery.must(queryBuilder1);
        subCodeQuery.must(queryBuilder2);
        subCodeQuery.must(queryBuilder3);
        subCodeQuery.must(queryBuilder4);
         */

        searchSourceBuilder.query(matchQuery(data));
        searchSourceBuilder.size(data.getPageSize());  //设置分页查询数量,根据前端传过来的页面数量值
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(Company.INDEX_NAME).addType(Company.TYPE).build();  //指定索引index以及类型type
        System.out.println(searchSourceBuilder.toString());
        try {
            JestResult result = jestClient.execute(search);
            return result.getSourceAsObjectList(Company.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 批量写入
     */
    public <T extends Company> void bulkIndex(List<T> list) {
        Bulk.Builder bulk = new Bulk.Builder();
        for (T o : list) {
            Index index = new Index.Builder(o).id(o.getId().toString()).index(T.INDEX_NAME).type(T.TYPE).build();
            bulk.addAction(index);
        }
        try {
            jestClient.execute(bulk.build());
        } catch (IOException e) {
            LOGGER.warn("bulkIndex again!! error={} index={}", e.getMessage(), T.INDEX_NAME);
            bulkIndex(list);
        }
    }

    /**
     * 新增或者更新文档
     */
    public <T> void insertOrUpdateDocumentById(T o, String index, String type, String uniqueId) {
        Index.Builder builder = new Index.Builder(o);
        builder.id(uniqueId);
        builder.refresh(true);
        Index indexDoc = builder.index(index).type(type).build();
        try {
            jestClient.execute(indexDoc);
        } catch (IOException e) {
            LOGGER.warn("insertOrUpdateDocumentById again!! error={} id={}", e.getMessage(), uniqueId);
            insertOrUpdateDocumentById(o, index, type, uniqueId);
        }
    }
}
