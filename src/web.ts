import { WebPlugin } from '@capacitor/core';

import type { CleanCachePlugin } from './definitions';

export class CleanCacheWeb extends WebPlugin implements CleanCachePlugin {
  async clearCache(): Promise<void> {
    console.log('Método no implementado para la web.');
  }

  async optimizeDevice(): Promise<void> {
    console.log('Método no implementado para la web.');
  }
}
