/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.handlers;

import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBindingBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesRoleBindingOperationsImpl;
import java.util.function.Predicate;
import okhttp3.OkHttpClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class KubernetesRoleBindingHandler implements ResourceHandler<KubernetesRoleBinding, KubernetesRoleBindingBuilder> {

  @Override
  public String getKind() {
    return KubernetesRoleBinding.class.getSimpleName();
  }

  @Override
  public KubernetesRoleBinding create(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).create();
  }

  @Override
  public KubernetesRoleBinding replace(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, true, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).replace(item);
  }

  @Override
  public KubernetesRoleBinding reload(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).fromServer().get();
  }

  @Override
  public KubernetesRoleBindingBuilder edit(KubernetesRoleBinding item) {
    return new KubernetesRoleBindingBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item, Watcher<KubernetesRoleBinding> watcher) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(watcher);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item, String resourceVersion, Watcher<KubernetesRoleBinding> watcher) {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).watch(resourceVersion, watcher);
  }

  @Override
  public KubernetesRoleBinding waitUntilReady(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilReady(amount, timeUnit);
  }

  @Override
  public KubernetesRoleBinding waitUntilCondition(OkHttpClient client, Config config, String namespace, KubernetesRoleBinding item, Predicate<KubernetesRoleBinding> condition, long amount, TimeUnit timeUnit) throws InterruptedException {
    return new KubernetesRoleBindingOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>()).waitUntilCondition(condition, amount, timeUnit);
  }
}
