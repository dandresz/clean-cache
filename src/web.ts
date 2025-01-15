import { WebPlugin } from '@capacitor/core';

import type { CleanCachePlugin } from './definitions';

export class CleanCacheWeb extends WebPlugin implements CleanCachePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
