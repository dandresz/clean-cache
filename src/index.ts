import { registerPlugin } from '@capacitor/core';

import type { CleanCachePlugin } from './definitions';

const CleanCache = registerPlugin<CleanCachePlugin>('CleanCache', {
  web: () => import('./web').then((m) => new m.CleanCacheWeb()),
});

export * from './definitions';
export { CleanCache };
