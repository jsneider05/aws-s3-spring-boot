package com.practice.awss3.domain.port.filestore;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public interface FileStore {

  void save(String path, String filename, Optional<Map<String, String>> optionalMetadata,
      InputStream inputStream);

  byte[] download(String path, String key);

}
