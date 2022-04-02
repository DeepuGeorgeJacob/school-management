#### @JsonIgnoreProperties(value = "hibernateLazyInitializer")
When you have JPA / Hibernate Entities with @Entity annotation, and when you fetch data from the database using a repository or using getMethod() from the parent entity for the field which is being lazy-loaded from the parent entity, hibernate returns an object which will have all the fields/properties of the class which are mapped to DB table. On top of these fields, this object will also have two extra fields which are hibernateLazyInitializer and handler that is used to lazily load an entity.

If you have any use case of serializing this entity in JSON String format using Jackson library directly or indirectly (Maybe if you're returning entity as it to any REST API response or if you're storing entity to JSON data store like Elasticsearch), the JPA entity will be serialized with all the fields and hibernateLazyInitializer and handler as extra fields. So, if you do not ignore these fields, they will be serialized in JSON format which you can see if you read the JSON string.

So, to avoid this unnecessary serialization, you have to write this piece of code on JPA / Hibernate entity which will tell Jackson library that "Serialized JSON should not have fields hibernateLazyInitializer and handler. If you find them in object, just ignore them":

```
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
```

#### @JsonInclude(JsonInclude.Include.NON_NULL)
To remove null fields from the response