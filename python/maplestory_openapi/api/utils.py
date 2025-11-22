def remove_query(url: str) -> str:
    if not isinstance(url, str):
        return url

    query_index = url.find('?')
    if query_index >= 0:
        return url[:query_index]
    else:
        return url