package com.test.test;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.SearchHits;

/**
 * Created by zhengying on 15/11/23.
 */
public class TestElastic {
    public static void main(String[] args) {
        Node node = new NodeBuilder().clusterName("elasticsearch").node();
        Client client = node.client();
        System.out.println(client);
        SearchResponse response = client.prepareSearch("users")
                .setTypes("user")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("name", "fox")) // Query
                .setPostFilter(FilterBuilders.rangeFilter("age").from(10).to(30)) // Filter
                .setFrom(0).setSize(60).setExplain(true).execute().actionGet();
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (int i = 0; i < hits.getHits().length; i++) {
            System.out.println(hits.getHits()[i].getSourceAsString());
        }

    }

}
